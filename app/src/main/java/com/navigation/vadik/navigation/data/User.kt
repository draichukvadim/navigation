package com.navigation.vadik.navigation.data

import java.util.HashMap

class User {
    var login: String? = null
    var id: Long? = null
    var nodeId: String? = null
    var avatarUrl: String? = null
    var gravatarId: String? = null
    var url: String? = null
    var htmlUrl: String? = null
    var followersUrl: String? = null
    var followingUrl: String? = null
    var gistsUrl: String? = null
    var starredUrl: String? = null
    var subscriptionsUrl: String? = null
    var organizationsUrl: String? = null
    var reposUrl: String? = null
    var eventsUrl: String? = null
    var receivedEventsUrl: String? = null
    var type: String? = null
    var siteAdmin: Boolean? = null
    var name: String? = null
    var company: String? = null
    var blog: String? = null
    var location: String? = null
    var email: String? = null
    var hireable: Boolean? = null
    var bio: String? = null
    var publicRepos: Int? = null
    var publicGists: Int? = null
    var followers: Int? = null
    var following: Int? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    private val additionalProperties = HashMap<String, Any>()

    fun getAdditionalProperties(): Map<String, Any> {
        return this.additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties[name] = value
    }

}