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
                    docker.build("Account:latest", "--no-cache .")
                }
            }
        }
    }
    post {
        success {
            stage('Deploy') {
                steps {
                    script {
                        docker.withRegistry('', 'docker-credentials-id') {
                            docker.image("Account:latest").push()
                        }
                        sh 'docker run -d -p 8080:8080 Account:latest'
                    }
                }
            }
        }
        failure {
            echo "One of the stages failed. Deployment will not proceed."
        }
    }
}
