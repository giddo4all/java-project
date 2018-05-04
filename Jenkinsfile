properties([pipelineTriggers([githubPush()])])


node('linux') {
    try {
	git 'https://github.com/giddo4all/java-project.git'
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ant -f build.xml -v"
    }
     stage('Deploy') {
          sh "aws s3 cp ${WORKSPACE}/dist/rectangle-${BUILD_NUMBER}.jar s3://ainajekins/rectangle-${BUILD_NUMBER}.jar"
    }
   } catch (Exception e) {
  currentBuild.result = 'FAILURE'   
} finally {
    echo pwd()
	    sh ("ls -la")
	    sh("ls -la ../")
    slackSend color: '#00FF00', message: 'Sent Finally'
}
           
}
