
def slackMsg(){

    //echo pwd()
	    //sh ("ls -la")
	   // sh("ls -la ../")
	def ny = 'gideon.aina@test.com'
	slackSend color: '#00FF00', message: getBuildStatus() +"\n " + getUserMentionID(ny)
}
return this

def getBuildStatus() {
    def stat = currentBuild.currentResult
    if (currentBuild?.getPreviousBuild()?.resultIsWorseOrEqualTo('FAILURE') && currentBuild.currentResult == "SUCCESS") {stat = 'BUILD_FIXED'}
    if (currentBuild?.getPreviousBuild()?.resultIsWorseOrEqualTo('FAILURE') && currentBuild.currentResult == "FAILURE") {stat = 'STILL_FAILING'}
    if (currentBuild?.getPreviousBuild()?.result == 'UNSTABLE' && currentBuild.currentResult == "SUCCESS") {stat = 'BUILD_STABLE'}
    return stat
}

def getUserMentionID(key){
	def slackID = sh (returnStdout: true, script: 'cat mention.slack | grep "$key": | cut -d: -f2')trim()
	
	echo"&%&%&%&%&%&%& " + slackID
	
	//def slk = load 'mention.slack'
	//def slk = readFile encoding: 'UTF-8', file: 'mention.slack'
	//sh("cat ${slk}")
	//def slkID = sh(returnStdout: true, script: "cat mention.slack")
	
	//def theList = slkID 	
	//echo theList
	//def userMentionMap = [:]
	//userMentionMap = slk
	//def theResult = theList.inject([:])
//	def userMentionMap = [
	//('gideon.aina@test.com'): '<@U85FWQDFW>'
//		slk
//]
	//def referenceFile = new File('mention.slack')
	//slk.inject([:]) { map, line ->
    	//def (name, reference) = line.split(",")
    	//map[name] = reference
    	//map
	//}
	//echo map
//return map.get(key)
	
//	def theList = slk
//	echo slk
//	echo"%%%%%%%%%%%%%%%%"
	//echo slk.getText()
//theResult = theList.inject([:])
//{
//    theMap, theListItem ->
//    def theEntry = theListItem.split(":")
//    theMap.put(theEntry[0].trim(), theEntry[1].trim())
//    theMap
//}
//println theResult
return "<@"+slackID+">"
}

