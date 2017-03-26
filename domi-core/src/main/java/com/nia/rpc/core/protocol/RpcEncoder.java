package com.nia.rpc.core.protocol;

import com.nia.rpc.core.serializer.KryoSerializer;
import com.nia.rpc.core.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码处理
 * Author 卡卡
 * Created by jing on 2017/3/26.
 */
public class RpcEncoder extends MessageToByteEncoder<Object> {

    private Serializer serializer = new KryoSerializer();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, ByteBuf out) throws Exception {

        byte[] bytes = serializer.serialize(msg);
        int length = bytes.length;
        out.writeInt(length);
        out.writeBytes(bytes);
    }
}
