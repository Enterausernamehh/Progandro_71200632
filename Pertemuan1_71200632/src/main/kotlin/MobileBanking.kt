open class MobileBanking (nama : String,saldo : Long, noRekening : String) :DigitalPayment(nama, saldo){
    var noRekening : String = noRekening
    var checkFee : Boolean = false
    var feeAntarBank : Long = 6000
        get() {
            return field
        }
        set(value) {
            field = value
        }
    override fun transfer(dp: DigitalPayment, nominal: Long) {
        if (nominal< 0) {
            println("input tidak valid")
        }
        else if ((nominal+this.feeAntarBank)>saldo) {
            println("Saldo tidak mencukupi")
        }
        else if (checkFee == true) {
            saldo = saldo - (nominal + this.feeAntarBank)
            dp.saldo = dp.saldo + nominal
            this.printBuktiTransfer(dp,nominal)
        }
        else if (checkFee == false) {
            saldo = saldo - nominal
            dp.saldo = dp.saldo + nominal
            this.printBuktiTransfer(dp,nominal)
        }
    }
}