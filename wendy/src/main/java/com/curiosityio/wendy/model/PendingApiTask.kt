package com.curiosityio.wendy.model

import com.curiosityio.wendy.vo.ErrorResponseVo
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmQuery
import retrofit2.Response
import rx.Completable
import rx.Observable
import java.util.*

interface PendingApiTask<RESPONSE: Any> {

    fun buildQueryForExistingTask(realmQuery: RealmQuery<RealmObject>): RealmQuery<RealmObject>

    fun canRunTask(realm: Realm): Boolean

    var created_at: Date

    fun getModelPendingApiTaskRepresents(realm: Realm): PendingApiModelInterface

    fun getApiCall(realm: Realm): Observable<Response<RESPONSE>>

    fun getApiErrorVo(): Class<ErrorResponseVo>

    fun processApiResponse(realm: Realm, response: RESPONSE)

}