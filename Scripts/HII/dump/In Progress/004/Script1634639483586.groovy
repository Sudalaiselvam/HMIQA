import core.AssertSteps

println AssertSteps.verifyDateInbetween('01/01/2021', '12/31/2021', '09/06/2021')

println AssertSteps.verifyDateInbetween('01/01/2021', '12/31/2021', '01/01/2021')

println AssertSteps.verifyDateInbetween('01/01/2021', '12/31/2021', '12/31/2021')

println AssertSteps.verifyDateInbetween('01/01/2021', '12/31/2021', '01/01/2022')

println AssertSteps.verifyDateInbetween('01/01/2021', '12/31/2021', '12/31/2020')