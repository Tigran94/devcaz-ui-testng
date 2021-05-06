You can run with the following script -> mvn clean test -Dbrowser={browser} -DsuiteXmlFile={filename} 
or you can just run the following script -> mvn clean test

Where

{browser} can be [firefox, chrome] default value is [firefox]
{filename} is the .xml file which you want to run , default value is [xmls/tests.xml]

note: allure can be used only after Jenkins integration