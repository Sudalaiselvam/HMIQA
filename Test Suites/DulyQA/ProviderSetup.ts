<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>ProviderSetup</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>3</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>true</rerunImmediately>
   <testSuiteGuid>9dd3d9ff-3cca-4958-8e18-f0a99dde809b</testSuiteGuid>
   <testCaseLink>
      <guid>88c2c18b-556c-47bf-ace8-a526b1ebde95</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>false</isRun>
      <testCaseId>Test Cases/HII/01_ProviderSetup/PS01_ValidateProviderSetupPageUI</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>d0297551-13be-41d7-a2dd-9992610b4399</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/01_ProviderSetup/PS02_ValidateProviderSearchTextBoxFunctionality</testCaseId>
      <testDataLink>
         <combinationType>MANY</combinationType>
         <id>bb15cdbf-76ae-4eae-b87b-5ba340bd085e</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/ProviderSetup/DulyQA/td_PS02_ValidateProviderSearchTextBoxFunctionality</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>bb15cdbf-76ae-4eae-b87b-5ba340bd085e</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>ProviderSearch</value>
         <variableId>2d0597cf-208f-4d2f-a164-41666351138f</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
