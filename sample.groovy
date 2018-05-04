def slackMsg(){

    echo pwd()
	    sh ("ls -la")
	    sh("ls -la ../")
    slackSend color: '#00FF00', message: 'Sent Finally'

}
return this
