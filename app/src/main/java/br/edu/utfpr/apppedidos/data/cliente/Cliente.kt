package br.edu.utfpr.apppedidos.data.cliente

import kotlinx.serialization.Serializable

@Serializable
class Cliente (
    val id: Int = 0,
    val nome: String = "",
    val cpf: String = "",
    val telefone: String = "",
    val endereco: Endereco = Endereco()
)