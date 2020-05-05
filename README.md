# Webpage Design Manipulator

Webpage Design Manipulator is a project to support the Webpage Design Manipulator extension through handling the manipulation of sent CSS in order to make the create the CSS to inject into the Webpage to make the desiered changes. 

## Prerequisites
Installed latest Version of Java

## Installing Extension Service API
An installer has been created to aid install.


## Running the Extension Service API
There is an exe file created to run this API.

## Server Details
Port:8080 

## HTML Extraction Endpoint 
URL: /HtmlExtraction

Parameters: None

Body: FullHTMLString - This can be any valid HTML

Output: Returns True or False on if HTML extraction was successful 

Additional Details: Stores the extracted HTML objects for that session

## CSS Extraction Endpoint 
URL: /CSSRules
Parameters: None

Body: JSON String of {"rules":  [<cssRuleset>,<cssRuleset>], "links":[externalStyleSheetLink]}

Body Example: {"rules":["* { box-sizing: border-box; }","body { font-family: Arial, Helvetica, sans-serif; }","header { background-color: rgb(102, 102, 102);],"links":[]}

Output: Returns True or False on if CSS extraction was successful 

Additional Details: Stores the extracted CSS Rulset objects for that session

## Save CSS Changes Endpoint
URL: /SaveCssChanges

Parameters: None

Body: JSON String of {"rules":  [<cssRuleset>,<cssRuleset>], "links":[externalStyleSheetLink]}

Body Example: {"rules":["* { box-sizing: border-box; }","body { font-family: Arial, Helvetica, sans-serif; }","header { background-color: rgb(102, 102, 102);],"links":[]}

Output: Returns True or False on if CSS Save was successful 

Additional Details: The must be HTML and CSS previously extracted in the session


## Contact
Email: jhughes61@qub.ac.uk

