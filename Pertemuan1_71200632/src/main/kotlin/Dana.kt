open class Dana (nama : String,saldo : Long, noHp : String):MobileWallet(nama,saldo, noHp) {
    var danaFeeTransferBank : Long = 1000
    override fun transfer(dp: DigitalPayment, nominal: Long) {
        if(dp is Ovo) {
            println("akun DANA tidak valid")
        }
        else if(dp is Dana){
            super.transfer(dp, nominal)
        }
        else {
            feeTransferBank = danaFeeTransferBank
            super.transfer(dp, nominal)
        }
    }
}