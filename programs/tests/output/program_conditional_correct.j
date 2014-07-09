.class public tests
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
	.limit stack 	512
	.limit locals 	512

	iconst_0
	istore 1
	iconst_0
	istore 2
	iload		1
	ldc 		0
	if_icmpeq			LBL0
	iconst_0
	goto			LBL1
	LBL0:
	iconst_1
	LBL1:

	iconst_1
	if_icmpne LBL2
	ldc 		4
	dup
	istore		1
	pop
	ldc 		5
	dup
	istore		2
	pop

	LBL2:

	iconst_0
	istore 3
	invokestatic tests/readBoolean()Z
	dup
	istore		3
	iconst_1
	if_icmpne		LBL4
	ldc 		1
	goto			LBL3
	LBL4:
	ldc 		2
	LBL3:
	dup
	istore		1
	pop
	iload		1
	ldc 		2
	if_icmpeq			LBL5
	iconst_0
	goto			LBL6
	LBL5:
	iconst_1
	LBL6:

	iconst_1
	if_icmpne LBL9
	iconst_0
	istore 4
	invokestatic tests/readBoolean()Z
	dup
	istore		4
	pop
	iload		4
	iconst_1
	if_icmpne		LBL8
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		121
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		101
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		115
	invokevirtual java/io/PrintStream/println(C)V

	goto			LBL7
	LBL8:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		110
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		111
	invokevirtual java/io/PrintStream/println(C)V

	LBL7:

	LBL9:


	return
.end method

.method                  private static readInteger()I
   .limit stack          1
   .limit locals         1
   .line                 12
LABEL0x0:
   invokestatic          tests/readLine()Ljava/lang/String;
   invokestatic          java/lang/Integer/parseInt(Ljava/lang/String;)I
LABEL0x6:
   ireturn               
   .line                 13
LABEL0x7:
   astore_0              
   .line                 14
   iconst_0              
   ireturn               
   .catch                java/lang/NumberFormatException from LABEL0x0 to LABEL0x6 using LABEL0x7
.end method              

.method                  private static readLine()Ljava/lang/String;
   .limit stack          5
   .limit locals         2
   .line                 19
   new                   java/io/BufferedReader
   dup                   
   new                   java/io/InputStreamReader
   dup                   
   getstatic             java/lang/System/in Ljava/io/InputStream;
   invokespecial         java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V
   invokespecial         java/io/BufferedReader/<init>(Ljava/io/Reader;)V
   astore_0              
   .line                 21
LABEL0x12:
   aload_0               
   invokevirtual         java/io/BufferedReader/readLine()Ljava/lang/String;
LABEL0x16:
   areturn               
   .line                 22
LABEL0x17:
   astore_1              
   .line                 23
   ldc                   ""
   areturn               
   .catch                java/io/IOException from LABEL0x12 to LABEL0x16 using LABEL0x17
.end method

.method                  private static readChar()C
   .limit stack          2
   .limit locals         1
   .line                 29
   invokestatic          tests/readLine()Ljava/lang/String;
   astore_0              
   .line                 30
   aload_0               
   invokevirtual         java/lang/String/length()I
   ifle                  LABEL0x13
   aload_0               
   iconst_0              
   invokevirtual         java/lang/String/charAt(I)C
   goto                  LABEL0x14
LABEL0x13:
   iconst_0              
LABEL0x14:
   ireturn               
.end method              

.method                  private static readBoolean()Z
   .limit stack          2
   .limit locals         1
   .line                 34
   invokestatic          tests/readLine()Ljava/lang/String;
   invokevirtual         java/lang/String/toLowerCase()Ljava/lang/String;
   astore_0              
   .line                 35
   aload_0               
   ldc                   "true"
   invokevirtual         java/lang/String/equals(Ljava/lang/Object;)Z
   ireturn               
.end method                        
              