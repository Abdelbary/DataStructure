 private class CircularBuffer{
        int[] bufferArr;
        int capacity;
        int readIndx;
        int writeIndx;
        CircularBuffer(int capacity)
        {
            bufferArr = new int[capacity];
            this.capacity = capacity;
            readIndx = 0;
            writeIndx = 0;
        }
        
        public void writeBuffer(int val)
        {
            ensureCapacity();
            bufferArr[writeIndx] = val;
            writeIndx = (writeIndx+1)%capacity;
        }
        
        public int readBuffer()
        {
            if(readIndx == writeIndx)
            {
                System.out.println("Buffer is Empty");
                return Integer.MIN_VALUE;
            }
            int val = bufferArr[readIndx];
            readIndx = (readIndx+1)%capacity;
            return val;
        }
        public boolean isEmpty()
        {
            return (readIndx == writeIndx);
        }
        
        public boolean isFull()
        {
            int nextIndx = (writeIndx+1)%capacity;
            return (nextIndx == readIndx);
        }
        public void ensureCapacity()
        {
            if(isFull())
            {
                bufferArr = Arrays.copyOf(bufferArr, 2*capacity);
                this.capacity = 2*this.capacity;
            }
        }
    }
