#!/bin/bash  
  git init
  git add /home/redhat/Desktop/seckill/*
  git commit -m "first commit"
  git remote add origin git@github.com:04143066/seckill.git
  git push -u origin master
