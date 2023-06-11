package com.zera.store.account.storage.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
class Account : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id : UUID? = null

    @Enumerated(EnumType.STRING)
    open var accountRole: AccountRole? = null
    @Column(nullable = false)
    open var userName: String? = null
    @Column(nullable = false)
    private var password: String? = null


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authority = SimpleGrantedAuthority(accountRole!!.name)
        return mutableListOf<GrantedAuthority>(authority)
    }

    override fun getPassword(): String = password!!

    fun setPassword(password: String) { this.password = password }

    override fun getUsername(): String = userName!!

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
