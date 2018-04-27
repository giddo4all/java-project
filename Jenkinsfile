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
         sh "ls -la ${WORKSPACE}/bin"
         sh "aws s3 cp ${WORKSPACE}/src/rectangle.jar s3.amazonaws.com/ainajenkins/rectangle-${BUILD_NUMBER}.jar"
    }
        stage('Report') {
        sh "env | sort"
        sh "ls -la"   
        sh "ls -la ${WORKSPACE}/reports"
        sh "ls -la ${WORKSPACE}/bin"
            
    }
}
