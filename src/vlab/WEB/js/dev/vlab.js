var Vlab = {

    div: null,

    setVariant: function (str) {
    },
    setPreviosSolution: function (str) {
    },
    setMode: function (str) {
    },

    //Инициализация ВЛ
    init: function () {
        const generatedNumbers = JSON.parse($("#preGeneratedCode").val());
        this.div = $("#jsLab").html(this.getAddRowBtn());
        this.div.append(this.generateRow(generatedNumbers[0], generatedNumbers[1]));

        //получение варианта задания
        // var ins = document.getElementById("preGeneratedCode").value;
        // this.div.innerHTML = ins;
    },

    getAddRowBtn() {
        return $("<button>Add row</button>").click(() => {
            this.div.append(this.generateRow());
        });
    },

    findElementInLab(id) {
        return this.div.find("#" + id);
    },

    generateRow(firstNumber, secondNumber) {
        const row = $("<div class='row'></div>");
        const firstInput = $("<input type='number'>").val(firstNumber);
        const minusSign = $("<span> - </span>");
        const secondInput = $("<input type='number'>").val(secondNumber);
        const result = $("<span class='row-result'></span>");
        const calculateBtn = $("<button type='button'>=</button>").click(() => {
            result.text(firstInput.val() - secondInput.val());
        });
        return row
            .append(firstInput)
            .append(minusSign)
            .append(secondInput)
            .append(calculateBtn)
            .append(result);
    },

    getCondition: function () {
    },
    getResults: function () {
        const rows = this.div.children(".row");
        const values = [];
        rows.each(function(){
            const stringNumber = $(this).find(".row-result").text().toString();
            values.push(parseInt(stringNumber));
        });
        return values;
    },
    calculateHandler: function (text, code) {
    }
};

window.onload = function () {
    Vlab.init();
};
