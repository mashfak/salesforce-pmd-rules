[![Build Status](https://travis-ci.org/CopadoSolutions/salesforce-pmd-rules.svg?branch=master)](https://travis-ci.org/CopadoSolutions/salesforce-pmd-rules)
# salesforce-pmd-rules
This repository contains custom rules developed by Copado customer's to extend Salesforce PMD default rules.

### Table of Contents
* [Project Configuration](#project-configuration)
* [Adding Custom Rules](#adding-custom-rules)
* [All Custom Rules](#all-custom-rules)
* [Next Steps](#next-steps)



### Project Configuration
Clone this respository and configure the project as maven project either importing it to your preferred IDE or using the maven command line interface. 

### Adding Custom Rules
1. Create a new branch out of master where the rule will be implemented. The naming convention for the branch is **rules/{company-name}**.

2. Implement the rule java class directly in the **copado.pmd.rules** package

3. Write test classes to cover the implemented rule code (in **test/java/copado.pmd.rules** package), the java class should be named with the Custom Rule name (**Custom_Rule_Name.java**)

3. Update the README to add the new rule to the [All Custom Rules](#all-custom-rules) table

4. Create a Pull Request to master branch

### All Custom Rules
| Rule Name | Rule Description | Source (Company Name)| 
| --- | --- | --- | 

### Next Steps
In order to use in Copado any custom rule from the [All Custom Rules](#all-custom-rules) table follow the instructions under:
https://docs.copa.do/article/05Ofsiuxmf-custom-pmd-rules-for-static-code-analysis

