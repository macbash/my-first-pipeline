#!/bin/bash
source /tmp/gitrevision
docker build -t appfuse:${commitid} .
