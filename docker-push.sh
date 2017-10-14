#!/bin/bash
ecr_repo="533678591672.dkr.ecr.us-east-1.amazonaws.com"

## AWS ECR Login

aws_ecr_access=$(aws ecr get-login --no-include-email --region us-east-1)
echo `eval ${aws_ecr_access}`

## Docker Image Tag & Push 

docker tag macbash-appfuse:latest ${ecr_repo}/appfuse:latest

docker push ${ecr_repo}/appfuse:latest
