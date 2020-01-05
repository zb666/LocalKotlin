package com.coroutine.bod.localkotlin.handle

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

/**
 * @ClassName: MessageQueue
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-05
 */
class MessageQueue{

    private val queue:BlockingQueue<BobMessage>  = ArrayBlockingQueue<BobMessage>(10)


    fun enqueueMessage(msg:BobMessage){
        try {
            queue.put(msg)
        }catch (t:Throwable){
            t.printStackTrace()
        }
    }

    fun next():BobMessage?{
        return try {
            queue.take()
        } catch (e: Exception) {
            e.printStackTrace()
        } as BobMessage?
    }

}
