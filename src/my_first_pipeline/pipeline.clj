(ns my-first-pipeline.pipeline
  (:use [lambdacd.steps.control-flow]
        [my-first-pipeline.steps])
  (:require
        [lambdacd.steps.manualtrigger :as manualtrigger]))

(def pipeline-def
  `(
    manualtrigger/wait-for-manual-trigger
    clean-up-source
    clean-up-project
    clone
    get-revision
    mvn-stage1
    mvn-test
    mvn-clean
    mvn-package
    docker-build
    docker-push
    ecs-task-definition-gen
   ecs-task-revision-update-service))

