package com.ford.mydaggerimpl

import javax.inject.Inject

class Model(val text: String)

class InjectableModel @Inject constructor(val firstValue: OneAnotherModel)

class OneAnotherModel @Inject constructor() {
    val value: Int = 5
}