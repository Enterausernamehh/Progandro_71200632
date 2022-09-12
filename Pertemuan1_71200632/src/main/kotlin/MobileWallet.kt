open class MobileWallet (nama : String,saldo : Long, noHp : String) :DigitalPayment(nama, saldo){
    var noHp : String = noHp
    var feeTransferBank : Long = 0
        get() {
            return field
        }
        set(value) {
            field = value
        }
    override fun transfer(dp: DigitalPayment, nominal: Long) {
        if (nominal < 0) {
            println("input tidak valid")
        }
        else if ((nominal+this.feeTransferBank)>saldo) {
            println("Saldo tidak mencukupi")
        }
        else if (dp is BNImo|| dp is BRImo) {
            saldo = saldo - (this.feeTransferBank + nominal)
            dp.saldo = dp.saldo + nominal
            this.printBuktiTransfer(dp,nominal)
        }
        else if (dp is Dana|| dp is Ovo) {
            saldo = saldo - (this.feeTransferBank + nominal)
            dp.saldo = dp.saldo + nominal
            this.printBuktiTransfer(dp,nominal)
        }

    }
}