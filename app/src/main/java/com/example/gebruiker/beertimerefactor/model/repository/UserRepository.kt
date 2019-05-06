package com.example.gebruiker.beertimerefactor.model.repository

import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.domain.IBaseRepository
import com.example.gebruiker.beertimerefactor.model.domain.IUserRepository
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.BaseRemoteSource
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.auth.FirebaseUser

class UserRepository(val userCachedSource: UserCachedSource, private val userRemoteSource: UserRemoteSource) : IUserRepository {

    override fun logout(): Boolean {
        return userCachedSource.empty()
    }

    override fun addUser(user: User) {
        userRemoteSource.addUser(user)
    }

    override fun getUser(): User? {
        return userCachedSource.getData()
    }

    override fun getUserFriends(userFriendsListener: UserRemoteSource.UserFriendsListener){
        return userRemoteSource.getUserFriends(userCachedSource.getData()!!.friendsID,userFriendsListener)
    }

    override fun getUserById(id: String, dataListener: IBaseRepository<User>) {
        userRemoteSource.getUserById(id, object : BaseRemoteSource.DataSnapShotListener {

            override fun onDataSnapShotInterrupted() {

            }

            override fun onDatSnapShotReceived(dataSnapShot: DataSnapshot) {
                val user = dataSnapShot.getValue(User::class.java)
                dataListener.onDataReceived(user!!)
            }
        })
    }

    override fun loginUser(email: String, password: String, onSuccessListener: IBaseRepository<Boolean>) {
        userRemoteSource.loginUser(email, password, object : UserRemoteSource.UserAuthenticationListener.UserLoginListener {

            override fun onUserLoginListener(fireBaseUser: FirebaseUser) {

                userRemoteSource.getUserById(fireBaseUser.uid, object : BaseRemoteSource.DataSnapShotListener {

                    override fun onDatSnapShotReceived(dataSnapShot: DataSnapshot) {
                        val user = dataSnapShot.getValue(User::class.java)
                        userCachedSource.putData(user!!)
                        onSuccessListener.onDataReceived(true)
                    }

                    override fun onDataSnapShotInterrupted() {

                    }

                })

            }
        })
    }

    override fun registerUser(email: String, password: String, onSuccessListener: IBaseRepository<Boolean>) {
        userRemoteSource.registerUser(email, password, object : UserRemoteSource.UserAuthenticationListener.RegisterListener {

            override fun onUserRegisterListener(fireBaseUser: FirebaseUser) {
                val user = User(fireBaseUser.email, fireBaseUser.uid)

                val friendList = ArrayList<String>()
                friendList.add("6Qxo8rpqkdN2OcBG552s4QLd10C2")
                friendList.add("H7uBcYISx7b5Ie40SdznJpnueg02")
                friendList.add("b2h4orZxK8UK5YTy2MiWkUSRHK82")
                friendList.add("jP5Czf7NaaX8e0BMewQidjLLoML2")

                user.setFriendID(friendList)

                userRemoteSource.addUser(user)

                onSuccessListener.onDataReceived(true)
            }
        })
    }


}