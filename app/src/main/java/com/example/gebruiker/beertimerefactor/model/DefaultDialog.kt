package com.example.gebruiker.beertimerefactor.model

import com.stfalcon.chatkit.commons.models.IDialog
import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser

class DefaultDialog : IDialog<IMessage> {

    override fun getDialogPhoto(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUnreadCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLastMessage(message: IMessage?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getId(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUsers(): MutableList<out IUser> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastMessage(): IMessage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDialogName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}