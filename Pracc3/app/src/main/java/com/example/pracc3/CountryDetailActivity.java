<LinearLayout
    android:id="@+id/linearLayout1"
    android:layout_width="149dp"
    android:layout_height="79dp"
    android:layout_marginBottom="16dp"  
    android:background="@color/white"
    android:orientation="vertical"
    android:padding="16dp"
    app:layout_constraintBottom_toTopOf="@+id/bottom_navigation"
    app:layout_constraintEnd_toStartOf="@+id/linearLayout2" 
    app:layout_constraintStart_toStartOf="parent" 
    app:layout_constraintTop_toBottomOf="@+id/linearLayout3"
    app:layout_constraintVertical_bias="1.0">

    <TextView
        android:id="@+id/tv_reading_time"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0 giờ"
        android:textColor="@color/black"
        android:textSize="16sp" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Đọc &amp; Nghe sách"
        android:textColor="@color/gray"
        android:textSize="14sp" />
</LinearLayout>

<LinearLayout
    android:id="@+id/linearLayout2"
    android:layout_width="149dp"
    android:layout_height="79dp"
    android:layout_marginBottom="16dp"  
    android:background="@color/white"
    android:orientation="vertical"
    android:padding="16dp"
    app:layout_constraintBottom_toTopOf="@+id/bottom_navigation"
    app:layout_constraintEnd_toEndOf="parent" 
    app:layout_constraintStart_toEndOf="@+id/linearLayout1" 
    app:layout_constraintTop_toBottomOf="@+id/linearLayout3"
    app:layout_constraintVertical_bias="1.0">

    <TextView
        android:id="@+id/tv_history"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Lịch sử"
        android:textColor="@color/black"
        android:textSize="16sp" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Đọc &amp; Nghe sách"
        android:textColor="@color/gray"
        android:textSize="14sp" />
</LinearLayout>
