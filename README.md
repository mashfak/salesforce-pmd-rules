# salesforce-pmd-rules
This repository contains custom rules developed by Copado customer's to extend Salesforce PMD default rules.

### Table of Contents
* [Project Configuration](#project-configuration)
* [Adding Custom Rules](#adding-custom-rules)
* [All Custom Rules](#all-custom-rules)


### Project Configuration
Clone this respository and configure the project as maven project either importing it to your preferred IDE or using the maven command line interface. 

### Adding Custom Rules
1. Create a new branch out of master where the rule will be implemented. The naming convention for the branch is **rules/{company-name}**.

2. Implement the rule java class directly in the **copado.pmd.rules** package

3. Update the README to add the new rule to the [All Custom Rules](#all-custom-rules) table

4. Create a Pull Request to master branch

### All Custom Rules
| Rule Name | Rule Description | Source (Company Name)| 
| --- | --- | --- | 
