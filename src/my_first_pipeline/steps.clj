(ns my-first-pipeline.steps
  (:require [lambdacd.steps.shell :as shell]
  [lambdacd-git.core :as lambdacd-git]))

(def repo-uri "https://github.com/macbash/appfuse.git")
(def repo-branch "master")

(defn clean-up-source [args ctx]
 (shell/bash ctx "/tmp/my-first-pipeline" "rm -rf appfuse" ))

(defn clean-up-project [args ctx]
 (shell/bash ctx "/tmp/my-first-pipeline" "rm -rf myproject" ))

(defn docker-pull [args ctx]
(shell/bash ctx "/tmp/my-first-pipeline" "./pull.sh"))

(defn wait-for-repo [args ctx]
  (lambdacd-git/wait-for-git ctx repo-uri :ref (str "refs/heads/" repo-branch)))

(defn clone [args ctx]
  (let [revision (:revision args)
        cwd      (:cwd args)
        ref      (or revision repo-branch)]
    (lambdacd-git/clone ctx repo-uri ref cwd)))


(defn mvn-stage1 [args ctx]
(shell/bash ctx (:cwd args) "mvn archetype:generate -B -DarchetypeGroupId=org.appfuse.archetypes -DarchetypeArtifactId=appfuse-basic-spring-archetype -DarchetypeVersion=3.5.0 -DgroupId=com.mycompany -DartifactId=myproject -DarchetypeRepository=https://oss.sonatype.org/content/repositories/appfuse"))

(defn mvn-test [args ctx]
(shell/bash ctx (:cwd args) "cd myproject && mvn test"))

(defn mvn-clean [args ctx]
(shell/bash ctx (:cwd args) "cd myproject && mvn clean"))

(defn mvn-package [args ctx]
(shell/bash ctx (:cwd args) "cd myproject && mvn package"))

(defn some-step-that-echos-bar [args ctx]
  (shell/bash ctx "/" "echo bar"))

(defn some-failing-step [args ctx]
  (shell/bash ctx "/" "echo exit"))

(defn docker-build [args ctx]
(shell/bash ctx "/tmp/my-first-pipeline" "./docker-build.sh"))

(defn docker-push [args ctx]
(shell/bash ctx "/tmp/my-first-pipeline" "./docker-push.sh"))
