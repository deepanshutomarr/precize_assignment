#!/bin/bash

echo "🚀 Building and Running Event-Driven Order Processing System"
echo "=========================================================="

# Build the project
echo "📦 Building project..."
mvn clean compile

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    
    # Run the main application
    echo "🎯 Running application..."
    mvn exec:java -Dexec.mainClass="com.ecommerce.OrderProcessingSystem"
    
    if [ $? -eq 0 ]; then
        echo "✅ Application completed successfully!"
    else
        echo "❌ Application failed!"
        exit 1
    fi
else
    echo "❌ Build failed!"
    exit 1
fi
