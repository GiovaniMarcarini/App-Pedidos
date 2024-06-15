package br.edu.utfpr.apppedidos.data.network

import br.edu.utfpr.apppedidos.data.cep.network.ApiCepService
import br.edu.utfpr.apppedidos.data.cliente.network.ApiClientesService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private val json = Json { ignoreUnknownKeys = true }
private val jsonConverterFactory = json.asConverterFactory("application/json".toMediaType())

private const val API_PEDIDOS_BASE_URL = "http://192.168.3.7:8080"
private val apiPedidosClient = Retrofit.Builder()
    .addConverterFactory(jsonConverterFactory)
    .baseUrl(API_PEDIDOS_BASE_URL)
    .build()

private const val API_CEP_BASE_URL = "https://viacep.com.br"
private val apiCepClient = Retrofit.Builder()
    .addConverterFactory(jsonConverterFactory)
    .baseUrl(API_CEP_BASE_URL)
    .build()

object ApiService {
    val clientes: ApiClientesService by lazy {
        apiPedidosClient.create(ApiClientesService::class.java)
    }
    val cep: ApiCepService by lazy {
        apiCepClient.create(ApiCepService::class.java)
    }
}