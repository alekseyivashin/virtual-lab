function generate(condition) {
    var generatingResult = Java.type('rlcp.generate.GeneratingResult');
    print(condition);
    //do Generate logic here
    var result = new generatingResult("JSText", "JSCode", "JSInstructions");
    return result;
}
