### Which DLX Solution to Choose?
####### Choose Only One Solution!

We can do automatic rejection by throwing AmqpRejectAndDontRequeueException, and manual rejection by using Channel and channel.basicReject(). Notice that on manual rejection, you have to change configuration on Spring's application.properties.

This configuration works for all consumers within your program. So if you're using manual rejection, you must also manually acknowledge processed message using channel.basicAck() for all consumers. Otherwise, the message will keep processed everytime consumer restarts.

At this point (with application.properties modified AND we didn't do any manual acknowledge on PictureXxxConsumer), if you publish a message into q.picture.xxx, and PictureXxxConsumer process it, the message will thrown back to queue as unacknowledged. When the consumer restarts, PictureXxxConsumer will re-process this message.

So choose only one approach for DLX error handling:

let Spring handles acknowledge, and throw AmqpRejectAndRequeueException

OR, do manual rejection



> So, Why Manual Reject?

Manual reject is risky. If we forget to manually acknowledge processed message, there's a possibility it will be re-processed. Why did I put it on this course?

Manual reject is basically not required. The benefit of using Spring is that Spring handles this kind of low-level, repetitive task for you. The reason I put it on this course are:

To let you know the concept

Preparing you for next section: Error Handling with Retry Mechanism