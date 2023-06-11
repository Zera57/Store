package com.zera.store.purchase.storage.model

import com.zera.store.product.storage.model.Product
import java.io.Serializable
import java.util.*

 class PurchaseId : Serializable {
     open var id: UUID? = null
     open var product: Product? = null
}
