package com.app.service.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

@Service
public class PodInfoService {
	
	@Autowired(required=false)
	private BuildProperties buildProperties;

    private static final String HOST_NAME = "HOSTNAME";

    private static final String APP_VERSION = "VERSION";

    private static final String DEFAULT_ENV_INSTANCE_GUID = "Localhost";

    private static final String DEFAULT_APP_VERSION = "NOT_DEFINED";

    @Value("${" + HOST_NAME + ":" + DEFAULT_ENV_INSTANCE_GUID + "}")
    private String hostName;

    @Value("${" + APP_VERSION + ":" + DEFAULT_APP_VERSION + "}")
    private String appVersion;

    public String getInfo() {
    	
    	String response = 
    			
    			"<html>\n" + 
    			"<head>\n" + 
    			"<style>\n" + 
    			"#appInfo {\n" + 
    			"  font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" + 
    			"  border-collapse: collapse;\n" + 
    			"  width: 100%;\n" + 
    			"}\n" + 
    			"\n" + 
    			"#appInfo td, #appInfo th {\n" + 
    			"  border: 1px solid #ddd;\n" + 
    			"  padding: 8px;\n" + 
    			"}\n" + 
    			"\n" + 
    			"#appInfo tr:nth-child(even){background-color: #f2f2f2;}\n" + 
    			"\n" + 
    			"#appInfo tr:hover {background-color: #ddd;}\n" + 
    			"\n" + 
    			"#appInfo th {\n" + 
    			"  padding-top: 12px;\n" + 
    			"  padding-bottom: 12px;\n" + 
    			"  text-align: left;\n" + 
    			"  background-color: #70a7ff;\n" + 
    			"  color: white;\n" + 
    			"}\n" + 
    			"</style>\n" + 
    			"</head>\n" + 
    			"<body>"
    			 +
    			
    			"<table id=\"appInfo\"> " +
    			"<tr>\n" + 
    			"    <th>Property</th>\n" + 
    			"    <th>Value</th>\n" + 
    			"  </tr>"+
    					"<tr>" +
							"<td>" + "Name" + "</td>" +
							"<td>" + (buildProperties != null ? buildProperties.getName() : "NA") + "</td>" +
						"</tr>" +
    					"<tr>" +
    						"<td>" + "Hostname" + "</td>" +
    						"<td>" + hostName + "</td>" +
    					"</tr>" +
						"<tr>" +
							"<td>" + "Build No." + "</td>" +
							"<td>" + (buildProperties != null ? buildProperties.getVersion() : "NA")  + "</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" + "Build Time" + "</td>" +
							"<td>" + (buildProperties != null ? buildProperties.getTime().toString() : "NA")  + "</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" + "k8s pod last 5" + "</td>" +
							"<td>" + hostName.substring(hostName.length()-5) + "</td>" +
						"</tr>" +
    			"</table></body>\n" + 
    			"</html>";
    	
    	
        return response;
    }

}
