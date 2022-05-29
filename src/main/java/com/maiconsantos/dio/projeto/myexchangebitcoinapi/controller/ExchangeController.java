package com.maiconsantos.dio.projeto.myexchangebitcoinapi.controller;

import com.maiconsantos.dio.projeto.myexchangebitcoinapi.model.Wallet;
import com.maiconsantos.dio.projeto.myexchangebitcoinapi.repository.WalletRepository;
import com.maiconsantos.dio.projeto.myexchangebitcoinapi.service.api.BitcoinInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    /*
     * This id is only used to always use the same wallet.
     * */
    private static final long ID = 1L;

    @Autowired
    private BitcoinInfo bitcoinInfo;

    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/bitcoin-price")
    public String bitcoinPrice() {
        String price = bitcoinInfo.info().getTicker().getLast();
        return price;
    }

    @PutMapping("/waller/deposit{money}")
    public void depositMoney(@PathVariable Double money) {
        Wallet wallet = getWaller();
        double moneyBalance = wallet.getMoneyBalance();
        wallet.setMoneyBalance(moneyBalance + money);
        walletRepository.save(wallet);
    }

    @GetMapping("/waller/balance-money")
    public Double balanceMoney() {
        return getWaller().getMoneyBalance();
    }

    @GetMapping("/waller/balance-bitcoin")
    public Double balanceBitcoin() {
        return getWaller().getMoneyBitcoin();
    }

    @PostMapping("/wallet/create")
    public void walletCreate(@RequestBody Wallet wallet) {
        walletRepository.save(wallet);
    }

    @DeleteMapping("/wallet/delete")
    public void walletDelete() {
        walletRepository.deleteAll();
    }

    @PostMapping("/wallet/money-to-bitcoin")
    public void moneyToBitcoin() {
        Wallet wallet = getWaller();
        Double balanceMoney = wallet.getMoneyBalance();
        Double bitcoinPrice = Double.valueOf(bitcoinInfo.info().getTicker().getLast());
        wallet.setMoneyBalance(0.0);
        wallet.setMoneyBitcoin(balanceMoney / bitcoinPrice);
        walletRepository.save(wallet);
    }

    @PostMapping("wallet/bitcoin-to-money")
    public void bitcoinToMoney() {
        Wallet wallet = getWaller();
        Double balanceBitcoin = wallet.getMoneyBitcoin();
        Double bitcoinPrice = Double.valueOf(bitcoinInfo.info().getTicker().getLast());
        wallet.setMoneyBitcoin(0.0);
        wallet.setMoneyBalance(balanceBitcoin * bitcoinPrice);
        walletRepository.save(wallet);
    }

    private Wallet getWaller() {
        Optional<Wallet> optionalWallet = walletRepository.findById(ID);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        } else {
            walletRepository.save(new Wallet("test", 0.0, 0.0));
            return walletRepository.findById(ID).get();
        }
    }
}
