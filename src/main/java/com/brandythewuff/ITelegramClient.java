package com.brandythewuff;

import com.brandythewuff.tresponsetypes.*;

public interface ITelegramClient{
    GetMeResponse GetMe();
    UpdateResponse GetUpdates();
}