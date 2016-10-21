package com.example.config.service


import com.example.account.AccountRepository
import com.example.account.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
open class UserDetailsServiceImpl constructor(val accountRepository: AccountRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val account = accountRepository.findByname(username)
        account.orElseThrow { UserNotFoundException("not found user name") }
        return account.get()
    }
}