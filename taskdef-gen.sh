#!/bin/bash
source /tmp/gitrevision
envsubst < taskDefinitionFile.json.tpl > /tmp/taskDefinitionFile.json

