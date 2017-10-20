#!/bin/bash

## ECS Details
cluster_name="appfuse"
service_name="appfuse-ecs-service"
taskDefinitionFile="/tmp/taskDefinitionFile.json"
awsRegion=$(cat ~/.aws/config | grep -i region | awk '{print $3}')


## Creating New Revision for Task Definition

taskdef=$(aws ecs register-task-definition --cli-input-json file://$taskDefinitionFile --region $awsRegion | jq ".[].taskDefinitionArn" | tr -d '"' | cut -d'/' -f 2)

## Updating Service with revision created in early step

aws ecs update-service --cluster "${cluster_name}" --service "${service_name}" --task-definition "${taskdef}" --region ${awsRegion-us-east-1}

