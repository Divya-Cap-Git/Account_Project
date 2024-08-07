pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/Divya-Cap-Git/Account_Project.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    try {
                        docker.build("Account:latest", "--no-cache .")
                    } catch (Exception e) {
                        echo "Docker build failed: ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }
        stage('Deploy Application') {
            steps {
                script {
                    try {
                        docker.image("${DOCKER_IMAGE}").run('-d -p 8081:8080')
                    } catch (Exception e) {
                        echo "Docker run failed: ${e.getMessage()}"
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }
    }
}
