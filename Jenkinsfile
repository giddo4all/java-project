properties([pipelineTriggers([githubPush()])])
node('linux') {
    git url: 'https://github.com/giddo4all/java-project.git', branch: 'master'
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ls -la"
    }
     stage('Deploy') {
        sh "pwd"
    }
        stage('Report') {
        sh "env"
        sh "ls -la"
            
    }
}
