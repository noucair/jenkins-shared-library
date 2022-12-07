#!/usr/bin/env groovy

import com.example.Docker

def call(String IMAGE_NAME) {
    return new Docker(this).dockerPush(IMAGE_NAME)
}

