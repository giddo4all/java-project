properties([pipelineTriggers([githubPush()])])
node('linux') {
    git url: 'https://github.com/giddo4all/java-project.git', branch: 'master'
    stage('Unit Tests') {
        sh "env"
    }
    stage('Build') {
        sh "ls -la"
    }
     stage('Deploy') {
        sh "pwd"
    }
        stage('Report') {
        echo "LastCard"
    }
}
