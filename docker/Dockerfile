#
# Created by @aazizzailani on 05/12/25
# © 2025, https://github.com/abdul-zailani. All rights reserved.
#
# Purpose: Jenkins master Docker image with JCasC plugin - MINIMAL
#

FROM jenkins/jenkins:lts

USER jenkins

# Copy plugins list
COPY docker/plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install plugins
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Copy JCasC configuration
COPY jcasc/ /usr/share/jenkins/ref/casc/

# Copy init.groovy.d scripts
COPY init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/

# Set JCasC environment variable
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/casc/jenkins.yaml

# Expose ports
EXPOSE 8080 50000
