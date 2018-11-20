
你真的了解try{ return }finally{}中的return？
-------------------------------------------

https://www.cnblogs.com/averey/p/4379646.html


看了问题后，得出了以下几个问题：

如果在 try 语句块里使用 return 语句，那么 finally 语句块还会执行吗？
  （如果你的答案是不会执行，请务必要看下去 ^_^）
如果执行，那么是怎样实现既执行 return 又执行 finally 的呢？
  （如果你的答案是不知道，请继续看下去！！）
上面的程序输出为什么是2？

  （ 如果不知道，继续看下去~~)

在网上看到还有人还问“是先执行return还是先执行finally？”

（个人觉得，如果知道finally会执行就可以得出是，先执行finally再执行return的。因为，如果先执行return，那么整个函
数都跳出了，那么还怎么执行finally？^_^）


验证 finally 语句是否会执行，以及 return 和 finally的执行顺序



     1.如果有返回值，就把返回值保存到局部变量中
     2.执行jsr指令跳到finally语句里执行
     3.执行完finally语句后，返回之前保存在局部变量表里的值


其实这里还有一点要注意的是，如果你在finally里也用了return语句，比如return +xx。那么y会是3。因为规范规定了，
当try和finally里都有return时，会忽略try的return，而使用finally的return。
