properties([pipelineTriggers([githubPush()])])
node('linux') {
    git url: 'https://github.com/giddo4all/java-project.git', branch: 'master'
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ant -f build.xml -v"
    }
     stage('Deploy') {
         sh "aws s3 cp ${WORKSPACE}/src/Rectangle.java https://s3.amazonaws.com/ainajenkins/Rectangle-${BUILD_NUMBER}.java"
    }
        stage('Report') {
        sh "env | sort"
        sh "ls -la"   
        sh "ls -la ${WORKSPACE}/reports"
        sh "ls -la ${WORKSPACE}/src"
            
    }
}
