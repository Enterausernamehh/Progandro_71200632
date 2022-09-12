open class BNImo (nama : String,saldo : Long, noRekening : String):MobileBanking(nama,saldo,noRekening) {
    override fun transfer(dp: DigitalPayment, nominal: Long) {
        if (dp is BRImo) {
            dp.checkFee = true
            super.transfer(dp, nominal)
        }
        else{
            super.transfer(dp, nominal)
        }
    }
}