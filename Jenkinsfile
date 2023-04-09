pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage ('build') {
            steps {
                step([$class: 'AlvariumBuilder', annotationType: 'TPM'])
                maven('test')
                step([$class: 'AlvariumBuilder', annotationType: 'GIT'])
                maven('package')
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            step([$class: 'AlvariumRecoder', annotationType: 'ARTIFACT'])
        }
    }
}