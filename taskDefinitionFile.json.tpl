{
  "family": "taskdef",
  "containerDefinitions": [
    {
      "volumesFrom": [],
      "portMappings": [
        {
          "hostPort": 8080,
          "containerPort": 80
        }
      ],
      "command": [],
      "links": [],
      "mountPoints": [],
      "essential": true,
      "memory": 256,
      "name": "container",
      "cpu": 100,
      "image": "533678591672.dkr.ecr.us-east-1.amazonaws.com/appfuse:${commitid}"
    }
  ],
  "volumes": []
}
