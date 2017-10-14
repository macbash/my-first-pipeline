# my-first-pipeline

A continuous delivery pipeline for my POC

## Usage

* `lein run` will start your pipeline with a web-ui listening on port 8080

## Files

* `/`
    * `project.clj` contains dependencies and build configuration for Leiningen

* `/src/my_first_pipeline/`
    * `pipeline.clj` contains your pipeline-definition
    * `steps.clj` contains your custom build-steps
    * `core.clj` contains the `main` function that wires everything together

* `/resources/`
    * `logback.xml` contains a sample log configuration


